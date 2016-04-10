(function () {
    'use strict';
    angular.module('app.customermaintenance').controller('ControllerEditCustomerAccount', ControllerEditCustomerAccount);
    /* @ngInject */
    function ControllerEditCustomerAccount(UserService,customerAccount,$state, $rootScope, $http) {
        /* jshint validthis: true */

        var vm = this;
        vm.formHeader = 'Edit User';
        vm.isNew =  false;
        vm.isView = false;
        vm.isEdit = true;
        vm.customerAccount = customerAccount;
        
        vm.updateCustomerAccount = function (user) {
       
        	$http.put('/customeraccount/update',customerAccount).then(function(response){
        		$state.go('app.listCustomerAccounts',{selectedOrgId: customerAccount.customerOrgId});
        		console.log(response);
        	});
        };
        
        vm.cancel = function() {
        	$state.go('app.listCustomerAccounts',{selectedOrgId: customerAccount.customerOrgId});
        };
      
    }
})();