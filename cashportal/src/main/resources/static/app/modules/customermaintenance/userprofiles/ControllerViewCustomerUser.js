(function () {
    'use strict';
    angular.module('app.customermaintenance').controller('ControllerViewCustomerUser', ControllerViewCustomerUser);
    /* @ngInject */
    function ControllerViewCustomerUser(UserService,userDetails,$state, $rootScope, $http) {
        /* jshint validthis: true */

        var vm = this;
        vm.formHeader = 'View Customer User';
        vm.isNew  =  false;
        vm.isEdit =  false
        vm.isView = true;
        vm.user = userDetails;
        vm.statusCodes = UserService.getStatusList();
        
        vm.cancel = function() {
        	$state.go('app.listCustomerUsers',{selectedOrgId: vm.user.orgId});
        };
      
    }
})();