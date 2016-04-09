(function () {
    'use strict';
    angular.module('app.customermaintenance').controller('ControllerViewCustomerPermissions', ControllerViewCustomerPermissions);
    /* @ngInject */
    function ControllerViewCustomerPermissions(OrganizationRoleService,organizationRoles,$state, $rootScope, $http) {
        /* jshint validthis: true */

        var vm = this;
        vm.formHeader = 'Edit Customer';
        vm.isView = true;
        vm.isEdit = false;
        vm.isNew  = false;
        
        vm.organizationRoles = organizationRoles;
        vm.assignedRoles  =  [];
        vm.availableRoles =  [];
    
        vm.cancel  = function() {
        	$state.go('app.listCustomerPermissions');
        };
      
    }
})();