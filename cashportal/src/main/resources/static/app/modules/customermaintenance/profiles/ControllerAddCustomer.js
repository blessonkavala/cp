(function () {
    'use strict';
    angular.module('app.customermaintenance').controller('ControllerAddCustomer', ControllerAddCustomer);
    /* @ngInject */
    function ControllerAddCustomer(OrganizationService,$state, $rootScope, $http) {
        /* jshint validthis: true */

        var vm = this;
        vm.statusCodes = OrganizationService.getStatusList();
        vm.legalTypeCodes = OrganizationService.getLegalIDTypes();
        vm.isView = false;
        vm.isEdit = false;
        vm.isNew  = true;
        
        vm.saveCustomer = function (org) {
       
        	$http.post('/organization/save',org).then(function(response){
        		$state.go('app.listCustomers');
        		console.log(response);
        	});
        	
        };
        
         vm.cancel  = function() {
        	$state.go('app.listCustomers');
        };
    }
})();