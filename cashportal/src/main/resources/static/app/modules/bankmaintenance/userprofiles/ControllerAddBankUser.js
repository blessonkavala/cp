(function () {
    'use strict';
    angular.module('app.bankmaintenance').controller('ControllerAddBankUser', ControllerAddBankUser);
    /* @ngInject */
    function ControllerAddBankUser(UserService,$state, $rootScope, $http,$stateParams) {
        /* jshint validthis: true */

        var vm = this;
        vm.formHeader = 'Add Bank User';
        vm.isNew =  true;
        vm.isView = false;
        vm.isEdit = false;
        vm.user = {};
        vm.user.orgId = $stateParams.selectedOrgId;
        vm.statusCodes = UserService.getStatusList();
        vm.saveUser = function (user) {
            //TODO:
           $http.post('/user/save',user).then(function(response){
        		$state.go('app.listBankUsers',{selectedOrgId: $stateParams.selectedOrgId});
        		console.log(response);
        	});
        	
        };
    }
})();