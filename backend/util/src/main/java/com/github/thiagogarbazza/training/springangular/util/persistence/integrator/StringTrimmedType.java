package com.github.thiagogarbazza.training.springangular.util.persistence.integrator;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import static org.apache.commons.lang3.StringUtils.trim;

class StringTrimmedType implements UserType {

  @Override
  public int[] sqlTypes() {
    return new int[] {Types.VARCHAR};
  }

  @Override
  public Class returnedClass() {
    return String.class;
  }

  @Override
  public boolean equals(Object x, Object y) {
    return (x == y) || (x != null && x.equals(y));
  }

  @Override
  public int hashCode(Object x) {
    return x == null ? 0 : x.hashCode();
  }

  @Override
  public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner) throws SQLException {
    String val = rs.getString(names[0]);

    return trim(val);
  }

  @Override
  public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session) throws SQLException {
    if (value == null) {
      st.setNull(index, Types.VARCHAR);
    } else {
      st.setString(index, (String) value);
    }
  }

  @Override
  public Object deepCopy(Object value) {
    if (value == null) {
      return null;
    }

    return new String(((String) value).toCharArray());
  }

  @Override
  public boolean isMutable() {
    return false;
  }

  @Override
  public Serializable disassemble(Object value) {
    return new String(((String) value).toCharArray());
  }

  @Override
  public Object assemble(Serializable cached, Object owner) {
    return new String(((String) cached).toCharArray());
  }

  @Override
  public Object replace(Object original, Object target, Object owner) {
    return original;
  }
}
