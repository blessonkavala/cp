(function () {
    'use strict';
    angular.module('app.bankmaintenance').controller('ControllerViewBankPermissions', ControllerViewBankPermissions);
    /* @ngInject */
    function ControllerViewBankPermissions(OrganizationRoleService,organizationRoles,$state, $rootScope, $http) {
        /* jshint validthis: true */

        var vm = this;
        vm.pageTitle="Display Bank Permissions";
        vm.isView = true;
        vm.isEdit = false;
        vm.isNew  = false;
        
        vm.organizationRoles = organizationRoles;
        vm.assignedRoles  =  [];
        vm.availableRoles =  [];
    
        vm.cancel  = function() {
        	$state.go('app.listBankPermissions');
        };
      
    }
})();