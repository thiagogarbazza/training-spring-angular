package com.github.thiagogarbazza.training.springangular.util.persistence.integrator;

import com.github.thiagogarbazza.training.springangular.util.persistence.enumeration.EnumIdentifiable;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.DynamicParameterizedType;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;

import static java.text.MessageFormat.format;

public class EnumIdentifiableType implements DynamicParameterizedType, UserType {

  private Class<? extends Enum> enumClass;

  @Override
  public int[] sqlTypes() {
    return new int[] {Types.INTEGER};
  }

  @Override
  public Class<? extends Enum> returnedClass() {
    return enumClass;
  }

  @Override
  public boolean equals(Object x, Object y) {
    return x == y;
  }

  @Override
  public int hashCode(Object x) {
    return x == null ? 0 : x.hashCode();
  }

  @Override
  public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner) throws SQLException {
    if (rs.wasNull()) {
      return null;
    }

    final int id = rs.getInt(names[0]);

    for (Enum value : returnedClass().getEnumConstants()) {
      if (value instanceof EnumIdentifiable) {
        EnumIdentifiable enumComCodigo = (EnumIdentifiable) value;
        if (enumComCodigo.getId().equals(id)) {
          return value;
        }
      }
    }

    throw new IllegalStateException(format("Não foi possível achar o item de id {0} em {1}.", id, returnedClass().getName()));
  }

  @Override
  public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session) throws SQLException {
    if (value == null) {
      st.setNull(index, Types.TINYINT);
    } else {
      final Object id = ((EnumIdentifiable) value).getId();
      st.setObject(index, id);
    }
  }

  @Override
  public Object deepCopy(Object value)  {
    return value;
  }

  @Override
  public boolean isMutable() {
    return false;
  }

  @Override
  public Serializable disassemble(Object value)  {
    return (Serializable) value;
  }

  @Override
  public Object assemble(Serializable cached, Object owner)  {
    return cached;
  }

  @Override
  public Object replace(Object original, Object target, Object owner)  {
    return original;
  }

  @Override
  public void setParameterValues(Properties parameters) {
    ParameterType params = (ParameterType) parameters.get(PARAMETER_TYPE);
    enumClass = params.getReturnedClass();
  }
}
