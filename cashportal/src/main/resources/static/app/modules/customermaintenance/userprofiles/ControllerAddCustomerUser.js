(function () {
    'use strict';
    angular.module('app.customermaintenance').controller('ControllerAddCustomerUser', ControllerAddCustomerUser);
    /* @ngInject */
    function ControllerAddCustomerUser(UserService,$state, $rootScope, $http,$stateParams) {
        /* jshint validthis: true */

        var vm = this;
        vm.pageTitle =  "Add Customer User Account";
        vm.isNew =  true;
        vm.isView = false;
        vm.isEdit = false;
        vm.user = {};
        vm.user.orgId = $stateParams.selectedOrgId;
        vm.statusCodes = UserService.getStatusList();
        vm.saveUser = function (user) {
            //TODO:
           $http.post('/user/save',user).then(function(response){
        		$state.go('app.listCustomerUsers',{selectedOrgId: $stateParams.selectedOrgId});
        		console.log(response);
        	});
        	
        };
    }
})();