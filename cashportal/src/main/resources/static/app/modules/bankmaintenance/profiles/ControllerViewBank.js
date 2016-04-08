(function () {
    'use strict';
    angular.module('app.bankmaintenance').controller('ControllerViewBank', ControllerViewBank);
    /* @ngInject */
    function ControllerViewBank(OrganizationService,organizationDetails,$state, $rootScope, $http) {
        /* jshint validthis: true */

        var vm = this;
        vm.formHeader = 'View Bank';
        vm.isView = true;
        vm.isEdit = false;
        vm.isNew  = false;
        vm.org = organizationDetails;
        vm.statusCodes = OrganizationService.getStatusList();
        vm.legalTypeCodes = OrganizationService.getLegalIDTypes();
        
        vm.cancel  = function() {
        	$state.go('app.listBanks');
        };
      
    }
})();