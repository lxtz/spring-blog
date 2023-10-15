import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {PostModel} from "./post.model";
import {lastValueFrom} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private http: HttpClient) {
  }

  async getPosts(): Promise<PostModel[]> {
    return lastValueFrom(this.http.get<PostModel[]>('http://localhost:8080/api/posts/'));
  }

  async getPost(id: number): Promise<PostModel> {
    return lastValueFrom(this.http.get<PostModel>(`http://localhost:8080/api/posts/${id}`));
  }

  async createPost(post: PostModel): Promise<PostModel> {
    return lastValueFrom(this.http.post<PostModel>(`http://localhost:8080/api/posts/`, post));
  }
}
