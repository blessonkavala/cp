(function () {
    'use strict';
    angular.module('app.bankmaintenance').controller('ControllerListBankPermissions', ControllerListBankPermissions);
    /* @ngInject */
    function ControllerListBankPermissions(OrganizationService,$state, $rootScope, $http , $stateParams) {
        /* jshint validthis: true */

        var vm = this;
        vm.organizations = null;
        OrganizationService.getOrganizationList().then(handleOrganizationList);
        
        function handleOrganizationList(organizations) {
            vm.organizations = organizations;
        }
        
        vm.viewBankPermissions = function (orgId){
            $state.go('app.viewBankPermissions', {orgId: orgId});
        };
        
        vm.editBankPermissions = function (orgId){
            $state.go('app.editBankPermissions', {orgId: orgId});
        };
    }
})();