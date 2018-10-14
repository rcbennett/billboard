import { Component, OnInit } from '@angular/core';
import { ResultsService } from '../shared'

@Component({
  selector: 'app-result-list',
  templateUrl: './result-list.component.html',
  styleUrls: ['./result-list.component.css'],
  providers: [ResultsService]
})

export class ResultListComponent implements OnInit {
  results: Array<any>;

  constructor(private resultsService: ResultsService) { }

  ngOnInit() {
    this.resultsService.getAll().subscribe(
      data => {
        this.results = data;
      },
      error => console.log(error)
    )
  }

}
