import {Component, OnInit} from '@angular/core';
import {PostModel} from "../post.model";
import {ActivatedRoute} from "@angular/router";
import {PostService} from "../post.service";

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.scss']
})
export class DetailComponent implements OnInit {

  id!: number;
  post?: PostModel;

  constructor(private route: ActivatedRoute, private postService: PostService) {
  }

  async ngOnInit() {
    this.id = Number(this.route.snapshot.paramMap.get('id'));
    this.post = await this.postService.getPost(this.id);
  }
}
