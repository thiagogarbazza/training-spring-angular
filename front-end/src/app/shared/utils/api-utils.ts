import pickBy from "lodash/pickBy";
import isArray from "lodash/isArray";
import isEmpty from "lodash/isEmpty";
import isUndefined from "lodash/isUndefined";
import isNull from "lodash/isNull";
import trim from "lodash/trim";


export class ApiUtils {

  public static removerUndefinedEmptyNull(parameters?: any) {
    return pickBy(parameters, value => {
      if (isArray(value)) {
        return !isEmpty(value);
      } else {
        return !isUndefined(value) && !isNull(value) && !isEmpty(trim(value));
      }
    });
  }
}
