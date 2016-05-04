(function () {
    'use strict';
    angular.module('app.customermaintenance').controller('ControllerAddCustomer', ControllerAddCustomer);
    /* @ngInject */
    function ControllerAddCustomer(OrganizationService,$state, $rootScope, $http) {
        /* jshint validthis: true */

        var vm = this;
        vm.pageTitle  = "Add Customer Account";
        vm.statusCodes = OrganizationService.getStatusList();
        vm.legalTypeCodes = OrganizationService.getLegalIDTypes();
        vm.isView = false;
        vm.isEdit = false;
        vm.isNew  = true;
        
        vm.saveCustomer = function (org) {
       
        	$http.post('/organization/save',org).then(function(response){
        		console.log(response);
                if(response.data.responseState ==='SUCCESS'){
                    $state.go('app.listCustomers');
                }
        		else
                {
                  vm.errorMessages =  response.data.errors;     
                }
        	});
        	
        };
        
         vm.cancel  = function() {
        	$state.go('app.listCustomers');
        };
    }
})();