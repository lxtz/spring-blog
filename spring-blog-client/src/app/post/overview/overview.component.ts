import {Component, OnInit} from '@angular/core';
import {PostModel} from "../post.model";
import {PostService} from "../post.service";

@Component({
  selector: 'app-overview',
  templateUrl: './overview.component.html',
  styleUrls: ['./overview.component.scss']
})
export class OverviewComponent implements OnInit {
  posts?: PostModel[];

  constructor(private postService: PostService) {
  }

  async ngOnInit() {
    this.posts = await this.postService.getPosts();
  }

}
