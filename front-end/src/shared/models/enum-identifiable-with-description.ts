export class EnumIdentifiableWithDescription {
  id: number;
  description: string;
  name: string;

  constructor(values: Object) {
    Object.assign(this, values);
  }
}
