<html ng-app="myApp">
<head>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
      <script src="static/js/app.js"></script>
      <script src="static/js/controller/sort_controller.js"></script>
      <style>
      .username.ng-valid {
          background-color: lightgreen;
      }
      .username.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      table {border-collapse:collapse; table-layout:fixed; width:500px;}
      table td {width:500px; word-wrap:break-word;}

    </style>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
     <link href="static/css/app.css" rel="stylesheet"></link>
</head>
<body>
<div class="generic-container" ng-controller="sort_controller">
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">Online Sorting </span></div>
              <div class="formcontainer">
                  <form name="myForm" class="form-horizontal">
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Enter values for Sorting</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="unSortedList" name="sortD" class="username form-control input-sm" placeholder="1,12,3,4,5,22226,7,8,319,10" required ng-pattern="patternSort"/>   
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.sortD.$error.required">This is a required field</span>  
                                      <span  ng-show="myForm.sortD.$error.pattern">Looks like number's is exceed 9 digits (or) commas(,) are not properly placed</span>                 
                                  </div>                               
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-actions floatLeft">
                              <input type="button"  ng-click ="sort()" value="Sort" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">                            
                          </div>
                      </div>
                  </form>
              </div>
          </div>
          <div class="panel panel-default" data-ng-init="getHistory()">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">History</span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>Unsorted Items</th>
                              <th>Sorted Items</th>
                              <th>No.of.Exchange</th>
                              <th>Time (ms)</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="u in list">
                              <td><span ng-bind="u.unSortedList"></span></td>
                              <td><span ng-bind="u.sortedList"></span></td>
                              <td><span ng-bind="u.noOfSteps"></span></td>
                              <td><span ng-bind="u.executionTime"></span></td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
</body>
</html>
