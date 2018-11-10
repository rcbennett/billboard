import {Component, OnInit, OnDestroy} from '@angular/core';
import { ResultsService } from '../shared';
import { timer } from 'rxjs';
import {AnonymousSubscription} from 'rxjs/Subscription';

@Component({
  selector: 'app-result-list',
  templateUrl: './result-list.component.html',
  styleUrls: ['./result-list.component.css'],
  providers: [ResultsService]
})

export class ResultListComponent implements OnInit, OnDestroy {
  results: Array<any>;
  private timerSubscription: AnonymousSubscription;
  private lastTimestamp: number;

  constructor(private resultsService: ResultsService) { }

  ngOnInit() {

    this.lastTimestamp = 0;
        this.subscribeToData();
  }

  public ngOnDestroy(): void {
    if (this.timerSubscription) {
      this.timerSubscription.unsubscribe();
    }
  }


  private subscribeToData(): void {
    const source = timer(500, 10000);
    this.timerSubscription = source.subscribe(() => this.refreshData());
  }

  refreshData() {

    this.resultsService.getAll().subscribe(
      data => {
        if (data.timestamp > this.lastTimestamp) {
          this.results = data.results;
          this.lastTimestamp = data.timestamp;
          console.log('refreshing - ' + data.timestamp);
        }
      },
      error => console.log(error)
    );
  }

}
