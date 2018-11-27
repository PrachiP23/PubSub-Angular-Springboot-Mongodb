import { Component, OnInit } from '@angular/core';
import { PubsubService } from '../shared/pubsub.service';
import { PUBLISHERS } from '../lists/mock-publishers';
import { SUBSCRIBERS} from '../lists/mock-subscribers';

@Component({
  selector: 'app-pubsub',
  templateUrl: './pubsub.component.html',
  styleUrls: ['./pubsub.component.css'],
  providers: [ PubsubService ]
})
export class PubsubComponent implements OnInit {

  
  constructor(private pubSubService: PubsubService) { }
  allpubs = PUBLISHERS;

  allsubs = SUBSCRIBERS;
  pubTopicCont = {};

  ngOnInit() {
    this.reload();
  }


  publishMessage(i, topic, content){
    this.allpubs[i].topCont.push({topic: topic, content: content});
    this.pubSubService.publishMessage(this.allpubs[i]).subscribe(data => console.log(data), error => console.log(error));
    this.allpubs[i].topCont.pop();  
    location.reload();
  }

  subscribeT(i, topic){
    this.allsubs[i].topicArr.push(topic);
    this.pubSubService.subscribeTopic(this.allsubs[i]).subscribe(data => console.log(data), error => console.log(error));
    this.allsubs[i].topicArr.pop();
    location.reload();
  }

  getAllPublishers(){
     this.pubSubService.getAllPublishers().subscribe(
       (data:any) => {
         console.log(data); 
         data.forEach(element => {
          this.allpubs.forEach(ele1 => {
            if(ele1.pubName === element.pubName){
              ele1.topContUI = element.topCont;
            }
          });  
          
         });
      },
       error => console.log(error));
    
  }

  getAllSubscribers(){
    this.pubSubService.getAllSubscribers().subscribe(
      (data:any) => {
        console.log(data);
        data.forEach(element => {
          this.allsubs.forEach(ele1 => {
            if(ele1.subName === element.subName){
              ele1.topicArrUI = element.topicArr;
              ele1.contentArr = element.content;
            }
          });
        });
      },
     error => console.log(error));
  }

  reload(){
    this.getAllPublishers();
    this.getAllSubscribers();
  }
}
