import { Component, OnInit } from '@angular/core';
import { SimpleMessage } from '@shared/components/simple-messages/simple-message';

@Component({
  selector: 'app-simple-messages',
  templateUrl: './simple-messages.component.html',
  styleUrls: ['./simple-messages.component.sass']
})
export class SimpleMessagesComponent implements OnInit {

  public custom: Array<SimpleMessage>;
  public error: Array<SimpleMessage>;
  public fatalErro: Array<SimpleMessage>;
  public info: Array<SimpleMessage>;
  public success: Array<SimpleMessage>;
  public warning: Array<SimpleMessage>;

  constructor() { }

  ngOnInit() {
  }

}
