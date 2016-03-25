(function () {
    'use strict';
    angular.module('app.organization').controller('AddOrganizationController', AddOrganizationController);
    /* @ngInject */
    function AddOrganizationController($state, $rootScope, $http) {
        /* jshint validthis: true */

        var vm = this;
        vm.saveOrganization = function (org) {
       
        	$http.post('/organization/save',org).then(function(response){
        		$state.go('app.dashboard');
        		console.log(response);
        	});
        	
        };
    }
})();