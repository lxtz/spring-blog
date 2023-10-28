import {Component, Inject, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {lastValueFrom} from "rxjs";
import {DOCUMENT} from "@angular/common";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  username?: string;
  password?: string;
  error: boolean = false;
  logout: boolean = false;

  constructor(private route: ActivatedRoute, @Inject(DOCUMENT) private document: Document, private http: HttpClient) {

  }

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      this.error = params["error"] != null;
      this.logout = params["logout"] != null;
    });
  }

  async onLoginClick() {
    try {
      const response = await lastValueFrom(this.http.post("/login", `username=${this.username}&password=${this.password}`, {
        headers: new HttpHeaders({"Content-Type": "application/x-www-form-urlencoded"}),
        responseType: "text",
        observe: 'response'
      }));
      if (response.ok && response.url) {
        this.error = false;
        this.document.location.href = response.url;
      }
    } catch (e) {
      this.error = true;
      console.log("Error logging in:", e);
    }
  }
}
