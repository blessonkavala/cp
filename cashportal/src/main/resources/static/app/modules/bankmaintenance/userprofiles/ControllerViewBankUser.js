(function () {
    'use strict';
    angular.module('app.user').controller('ControllerViewBankUser', ControllerViewBankUser);
    /* @ngInject */
    function ControllerViewBankUser(UserService,userDetails,$state, $rootScope, $http) {
        /* jshint validthis: true */

        var vm = this;
        vm.formHeader = 'View Bank User';
        vm.isNew  =  false;
        vm.isEdit =  false
        vm.isView = true;
        vm.user = userDetails;
        vm.statusCodes = UserService.getStatusList();
        
        vm.cancel = function() {
        	$state.go('app.listBankUsers',{selectedOrgId: vm.user.orgId});
        };
      
    }
})();