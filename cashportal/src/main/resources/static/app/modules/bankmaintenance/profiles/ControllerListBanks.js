(function () {
    'use strict';
    angular.module('app.bankmaintenance').controller('ControllerListBanks', ControllerListBanks);
    /* @ngInject */
    function ControllerListBanks(OrganizationService,$state, $rootScope, $http) {
        /* jshint validthis: true */

        var vm = this;
        vm.organizations = null;
        vm.viewBank = viewBank;
        vm.editBank = editBank;
        vm.statusCodes = OrganizationService.getStatusList();
        OrganizationService.getOrganizationList().then(handleOrganizationList);
        
        function handleOrganizationList(organizations) {
        vm.organizations = organizations;
        }

        function viewBank(rid) {
            $state.go('app.viewBank', {rid: rid});
        }
        
         function editBank(rid) {
            $state.go('app.editBank', {rid: rid});
        }
      
    }
})();