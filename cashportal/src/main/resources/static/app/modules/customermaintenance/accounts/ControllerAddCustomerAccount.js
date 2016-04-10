(function () {
    'use strict';
    angular.module('app.customermaintenance').controller('ControllerAddCustomerAccount', ControllerAddCustomerAccount);
    /* @ngInject */
    function ControllerAddCustomerAccount($state, $rootScope, $http,$stateParams) {
        /* jshint validthis: true */

        var vm = this;
        vm.formHeader = 'Add Customer User';
        vm.isNew =  true;
        vm.isView = false;
        vm.isEdit = false;
        vm.customerAccount = {};
        vm.customerAccount.account = {};
        vm.customerAccount.customerOrgId = $stateParams.selectedOrgId;
      
        vm.saveCustomerAccount = function () {
           $http.post('/customeraccount/save',vm.customerAccount).then(function(response){
        		$state.go('app.listCustomerAccounts',{selectedOrgId: $stateParams.selectedOrgId});
        		console.log(response);
        	});
        	
        };
    }
})();