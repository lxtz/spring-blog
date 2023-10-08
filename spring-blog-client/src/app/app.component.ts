import {Component} from '@angular/core';
import {HelloService} from "./hello.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  clientHello?: string;
  serverHello?: string;

  constructor(private helloService: HelloService) {
    this.clientHello = helloService.helloClient();
    helloService.helloServer().subscribe((value) => this.serverHello = value);
  }
}
