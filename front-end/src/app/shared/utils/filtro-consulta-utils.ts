import { Identifiable } from '@shared/models/identifiable';

export class FiltroConsultaUtil {

  static converteObjectToIds(objects: Array<Identifiable>): Array<string> {
    if(objects) {
      return objects.map(item => item.id);
    }

    return new Array();
  }
}
