(function () {
    'use strict';
    angular.module('app.customermaintenance').controller('ControllerListCustomers', ControllerListCustomers);
    /* @ngInject */
    function ControllerListCustomers(OrganizationService,$state, $rootScope, $http) {
        /* jshint validthis: true */

        var vm = this;
        vm.organizations = null;
        vm.viewCustomer = viewCustomer;
        vm.editCustomer = editCustomer;
        vm.statusCodes = OrganizationService.getStatusList();
        OrganizationService.getOrganizationList().then(handleOrganizationList);
        
        function handleOrganizationList(organizations) {
        vm.organizations = organizations;
        }

        function viewCustomer(rid) {
            $state.go('app.viewCustomer', {rid: rid});
        }
        
         function editCustomer(rid) {
            $state.go('app.editCustomer', {rid: rid});
        }
      
    }
})();