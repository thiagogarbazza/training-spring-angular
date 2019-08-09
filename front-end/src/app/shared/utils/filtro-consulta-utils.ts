import { Identifiable } from '@shared/models/identifiable';

export class FiltroConsultaUtil {

  static converteDateToString(item: Date): string {
    if(item) {
      return '';
    }

    return null;
  }

  static converteObjectToId(item: Identifiable): string {
    if(item) {
      return item.id;
    }

    return null;
  }

  static converteObjectToIds(objects: Array<Identifiable>): Array<string> {
    if(objects) {
      return objects.map(item => item.id);
    }

    return new Array();
  }
}
