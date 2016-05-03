(function () {
    'use strict';
    angular.module('app.bankmaintenance').controller('ControllerAddBank', ControllerAddBank);
    /* @ngInject */
    function ControllerAddBank(OrganizationService,$state, $rootScope, $http) {
        /* jshint validthis: true */

        var vm = this;
        vm.pageTitle="Add Bank Account";
        vm.statusCodes = OrganizationService.getStatusList();
        vm.legalTypeCodes = OrganizationService.getLegalIDTypes();
        vm.isView = false;
        vm.isEdit = false;
        vm.isNew  = true;
        vm.errorMessages  = [];
        
        vm.saveBank = function (org) {
       
        	$http.post('/organization/save',org).then(function(response){
                console.log(response);
                if(response.data.responseState ==='SUCCESS'){
                    $state.go('app.listBanks');
                }
        		else
                {
                  vm.errorMessages =  response.data.errors;     
                }
        	});
        };
        
         vm.cancel  = function() {
        	$state.go('app.listBanks');
        };
    }
})();