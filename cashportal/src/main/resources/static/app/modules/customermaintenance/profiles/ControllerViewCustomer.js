(function () {
    'use strict';
    angular.module('app.customermaintenance').controller('ControllerViewCustomer', ControllerViewCustomer);
    /* @ngInject */
    function ControllerViewCustomer(OrganizationService,organizationDetails,$state, $rootScope, $http) {
        /* jshint validthis: true */

        var vm = this;
        vm.pageTitle  = "Display Customer Account";
        vm.isView = true;
        vm.isEdit = false;
        vm.isNew  = false;
        vm.org = organizationDetails;
        vm.statusCodes = OrganizationService.getStatusList();
        vm.legalTypeCodes = OrganizationService.getLegalIDTypes();
        
        vm.cancel  = function() {
        	$state.go('app.listCustomers');
        };
      
    }
})();