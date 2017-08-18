'use strict';

angular
		.module('myApp')
		.controller(
				'sort_controller',
				[
						'$http',
						'$scope',
						
						function($http, $scope) {
							var self = this;
							var Sorting = {
								guid : '',
								unSortedList : '',
								SortedList : '',
								executionTime : '',
								noOfSteps : ''
							};
							var list = [];

							$scope.patternSort = (function() {
														      //var regexp = /^[0-9](,[0-9])*$/;
														      var regexp = /^[0-9]{1,9}(,[0-9]{1,9})*$/;
														      return {
														        test: function(value) {
														        	console.log(regexp.test(value))
														          return regexp.test(value);
														        }
														      };
														    })();

							$scope.sort = function() {
								if($scope.unSortedList !=''){
    								Sorting.unSortedList = $scope.unSortedList;
    								if (localStorage.getItem("guid") != null) {
    									Sorting.guid = localStorage.getItem("guid");
    								}
    								$http
    										.post(
    												'http://localhost:7001/OnlineSort/json/sorting',
    												Sorting).success(
    												function(data) {
    													console.log(data);
    													if (data.guid != null) {
    														localStorage.setItem(
    																"guid",
    																data.guid);
    													}

    													$scope.list = data.sorting;
    												}).error(function(data) {
    										});

                                }
							}

							$scope.getHistory = function() {

								if (localStorage.getItem("guid") != null) {
										$http.put('http://localhost:7001/OnlineSort/json/sorting/'+localStorage.getItem("guid")).then(function(data) {                                            
												$scope.list = data.data.sorting;
                                                console.log(list);
										}, function(x) {

										});
								}

							}

						} ]);
