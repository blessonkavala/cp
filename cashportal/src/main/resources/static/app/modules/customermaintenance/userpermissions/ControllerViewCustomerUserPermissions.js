(function () {
    'use strict';
    angular.module('app.customermaintenance').controller('ControllerViewCustomerUserPermissions', ControllerViewCustomerUserPermissions);
    /* @ngInject */
    function ControllerViewCustomerUserPermissions(userRoles,$state, $rootScope, $http) {
        /* jshint validthis: true */

        var vm = this;
        vm.formHeader = 'Edit Customer User Permissions';
        vm.isView = true;
        vm.isEdit = false;
        vm.isNew  = false;
        
        vm.userRoles = userRoles;
        vm.assignedRoles  =  [];
        vm.availableRoles =  [];
        
        vm.cancel  = function() {
        	$state.go('app.listCustomerUsersPermissions',{selectedOrgId: userRoles.user.orgId});
        };
      
    }
})();