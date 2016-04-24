(function () {
    'use strict';
    angular.module('app.user').controller('ControllerEditBankUser', ControllerEditBankUser);
    /* @ngInject */
    function ControllerEditBankUser(UserService,userDetails,$state, $rootScope, $http) {
        /* jshint validthis: true */

        var vm = this;
        vm.pageTitle="Modify Bank User Account";
        vm.isNew =  false;
        vm.isView = false;
        vm.isEdit = true;
        vm.user = userDetails;
        vm.statusCodes = UserService.getStatusList();
        
        vm.updateUser = function (user) {
       
        	$http.put('/user/update',user).then(function(response){
        		$state.go('app.listBankUsers',{selectedOrgId: user.orgId});
        		console.log(response);
        	});
        	
        };
        
        vm.cancel = function() {
        	$state.go('app.listBankUsers',{selectedOrgId: vm.user.orgId});
        };
      
    }
})();