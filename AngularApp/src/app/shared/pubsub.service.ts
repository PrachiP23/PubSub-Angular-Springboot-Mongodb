import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Publisher } from '../models/publisher';
import { Subscriber } from '../models/subscriber';

@Injectable({
  providedIn: 'root'
})
export class PubsubService {
 
  selectedPub: Publisher;
  selectedSub: Subscriber;
  allPubs: Publisher[];
  allSubs: Subscriber[];


  private baseUrl = 'http://localhost:8080/api';
  constructor(private http: HttpClient) { }

  publishMessage(publisher: Publisher){
    return this.http.post(`${this.baseUrl}`+`/publish`, publisher);
  }


  subscribeTopic(subscriber: Subscriber){
    return this.http.post(`${this.baseUrl}`+`/subscribe`, subscriber);
  }

  notify(){
    return this.http.post(`${this.baseUrl}`, "");
  }

  getAllPublishers(){
    return this.http.get(`${this.baseUrl}`+`/allPubs`);
  }

  getAllSubscribers(){
    return this.http.get(`${this.baseUrl}`+`/allSubs`);
  }
}
