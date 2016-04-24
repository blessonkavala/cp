(function () {
    'use strict';
    angular.module('app.customermaintenance').controller('ControllerEditCustomer', ControllerEditCustomer);
    /* @ngInject */
    function ControllerEditCustomer(OrganizationService,organizationDetails,$state, $rootScope, $http) {
        /* jshint validthis: true */

        var vm = this;
        vm.pageTitle  = "Modify Existing Customer Account";
        vm.formHeader = 'Edit Customer';
        vm.isView = false;
        vm.isEdit = true;
        vm.isNew  = false;
        
        vm.org = organizationDetails;
        vm.statusCodes = OrganizationService.getStatusList();
        vm.legalTypeCodes = OrganizationService.getLegalIDTypes();
        
        vm.updateCustomer = function (org) {
       
        	$http.put('/organization/update',org).then(function(response){
        		$state.go('app.listCustomers');
        		console.log(response);
        	});
        	
        };
        
       vm.cancel  = function() {
        	$state.go('app.listCustomers');
        };
      
    }
})();