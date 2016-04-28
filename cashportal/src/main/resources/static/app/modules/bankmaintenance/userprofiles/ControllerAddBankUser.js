(function () {
    'use strict';
    angular.module('app.bankmaintenance').controller('ControllerAddBankUser', ControllerAddBankUser);
    /* @ngInject */
    function ControllerAddBankUser(UserService,$state, $rootScope, $http,$stateParams) {
        /* jshint validthis: true */

        var vm = this;
        vm.pageTitle="Add Bank User Account";
        vm.isNew =  true;
        vm.isView = false;
        vm.isEdit = false;
        vm.user = {};
        vm.user.orgId = $stateParams.selectedOrgId;
        vm.statusCodes = UserService.getStatusList();
        vm.errorMessages  = [];
        vm.saveUser = function (user) {
            //TODO:
           $http.post('/user/save',user).then(function(response){
                console.log(response);
                if(response.data.responseState ==='SUCCESS'){
                    $state.go('app.listBankUsers',{selectedOrgId: $stateParams.selectedOrgId});    
                }
        		else{
                  vm.errorMessages =  response.data.errors;     
                }
        	});
        	
        };
        
        vm.cancel = function(){
          $state.go('app.listBankUsers',{selectedOrgId: $stateParams.selectedOrgId});  
        };
    }
})();