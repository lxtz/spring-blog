import {Component} from '@angular/core';
import {PostService} from "../post.service";
import {PostModel} from "../post.model";
import {Router} from "@angular/router";

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.scss']
})
export class CreateComponent {

  author?: string;
  title?: string;
  content?: string;
  invalid: boolean = false;

  constructor(private router: Router, private postService: PostService) {
  }

  async onCreateClick() {
    try {
      const createdPost = await this.postService.createPost(<PostModel>{
        author: this.author,
        title: this.title,
        content: this.content
      })
      if (createdPost.id) {
        this.invalid = false;
        await this.router.navigate([`/post/${createdPost.id}`]);
      }
    } catch (e) {
      this.invalid = true;
      console.log("Error creating post:", e);
    }
  }
}
