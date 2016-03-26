(function () {
    'use strict';
    angular.module('app.organization').controller('ViewOrganizationController', ViewOrganizationController);
    /* @ngInject */
    function ViewOrganizationController(OrganizationService,organizationDetails,$state, $rootScope, $http) {
        /* jshint validthis: true */

        var vm = this;
        vm.formHeader = 'View Party';
        vm.isView = true;
        vm.org = organizationDetails;
        vm.statusCodes = OrganizationService.getStatusList();
        vm.legalTypeCodes = OrganizationService.getLegalIDTypes();
        
         function cancel() {
        	$state.go('main.partymanagement-dashboard');
        }
      
    }
})();