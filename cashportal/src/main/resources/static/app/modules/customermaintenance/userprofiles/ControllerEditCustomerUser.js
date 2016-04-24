(function () {
    'use strict';
    angular.module('app.customermaintenance').controller('ControllerEditCustomerUser', ControllerEditCustomerUser);
    /* @ngInject */
    function ControllerEditCustomerUser(UserService,userDetails,$state, $rootScope, $http) {
        /* jshint validthis: true */

        var vm = this;
        vm.pageTitle =  "Modify Customer User Account";
        vm.isNew =  false;
        vm.isView = false;
        vm.isEdit = true;
        vm.user = userDetails;
        vm.statusCodes = UserService.getStatusList();
        
        vm.updateUser = function (user) {
       
        	$http.put('/user/update',user).then(function(response){
        		$state.go('app.listCustomerUsers',{selectedOrgId: user.orgId});
        		console.log(response);
        	});
        	
        };
        
        vm.cancel = function() {
        	$state.go('app.listCustomerUsers',{selectedOrgId: vm.user.orgId});
        };
      
    }
})();