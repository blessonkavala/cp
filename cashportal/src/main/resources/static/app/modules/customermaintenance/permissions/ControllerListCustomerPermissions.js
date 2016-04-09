(function () {
    'use strict';
    angular.module('app.customermaintenance').controller('ControllerListCustomerPermissions', ControllerListCustomerPermissions);
    /* @ngInject */
    function ControllerListCustomerPermissions(OrganizationService,$state, $rootScope, $http , $stateParams) {
        /* jshint validthis: true */

        var vm = this;
        vm.organizations = null;
        OrganizationService.getOrganizationList().then(handleOrganizationList);
        
        function handleOrganizationList(organizations) {
            vm.organizations = organizations;
        }
        
        vm.viewCustomerPermissions = function (orgId){
            $state.go('app.viewCustomerPermissions', {orgId: orgId});
        };
        
        vm.editCustomerPermissions = function (orgId){
            $state.go('app.editCustomerPermissions', {orgId: orgId});
        };
    }
})();