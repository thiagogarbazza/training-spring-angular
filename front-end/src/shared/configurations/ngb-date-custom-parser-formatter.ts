import { Injectable } from '@angular/core';
import padStart from "lodash/padStart";

import { NgbDateParserFormatter, NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';

@Injectable()
export class NgbDateCustomParserFormatter extends NgbDateParserFormatter {
  parse(value: string): NgbDateStruct {
    if (value) {
      const dateParts = value.trim().split('-');
      if (dateParts.length === 3) {
        return {day: +dateParts[0], month: +dateParts[1], year: +dateParts[2]};
      }
    }
    return null;
  }

  format(date: NgbDateStruct): string {
    return date ?
      `${padStart(date.day, 2, 0)}/${padStart(date.month, 2, 0)}/${padStart(date.year, 4, 0)}` :
      '';
  }
}
