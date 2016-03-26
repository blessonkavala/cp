(function () {
    'use strict';
    angular.module('app.organization').controller('ListOrganizationController', ListOrganizationController);
    /* @ngInject */
    function ListOrganizationController(OrganizationService,$state, $rootScope, $http) {
        /* jshint validthis: true */

        var vm = this;
        vm.organizations = null;
        vm.viewOrganization = viewOrganization;
        vm.editOrganization = editOrganization;
        vm.statusCodes = OrganizationService.getStatusList();
        OrganizationService.getOrganizationList().then(handleOrganizationList);
        
        function handleOrganizationList(organizations) {
        vm.organizations = organizations;
        }

        function viewOrganization(rid) {
            $state.go('viewOrganization', {rid: rid});
        }
        
         function editOrganization(rid) {
            $state.go('editOrganization', {rid: rid});
        }
      
    }
})();