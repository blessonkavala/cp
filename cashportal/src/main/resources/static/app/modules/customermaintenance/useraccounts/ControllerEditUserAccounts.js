(function () {
    'use strict';
    angular.module('app.customermaintenance').controller('ControllerEditUserAccounts', ControllerEditUserAccounts);
    /* @ngInject */
    function ControllerEditUserAccounts(UserService,userAccountsDetails,$state, $rootScope, $http) {
        /* jshint validthis: true */

        var vm = this;
        vm.formHeader = 'Edit User';
        vm.isNew =  false;
        vm.isView = false;
        vm.isEdit = true;
        vm.userAccountsDetails = userAccountsDetails;
        
        vm.updateUserAccounts = function () {
       
        	$http.put('/useraccounts/update',vm.userAccountsDetails).then(function(response){
        		$state.go('app.listUserAccounts',{selectedOrgId: userAccountsDetails.customerOrgId});
        		console.log(response);
        	});
        };
        
        vm.cancel = function() {
        	$state.go('app.listUserAccounts',{selectedOrgId: userAccountsDetails.customerOrgId});
        };
      
    }
})();