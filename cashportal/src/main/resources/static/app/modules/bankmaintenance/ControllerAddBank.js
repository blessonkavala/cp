(function () {
    'use strict';
    angular.module('app.bankmaintenance').controller('ControllerAddBank', ControllerAddBank);
    /* @ngInject */
    function ControllerAddBank(OrganizationService,$state, $rootScope, $http) {
        /* jshint validthis: true */

        var vm = this;
        vm.statusCodes = OrganizationService.getStatusList();
        vm.legalTypeCodes = OrganizationService.getLegalIDTypes();
        vm.isView = false;
        vm.isEdit = false;
        vm.isNew  = true;
        
        vm.saveBank = function (org) {
       
        	$http.post('/organization/save',org).then(function(response){
        		$state.go('app.listBanks');
        		console.log(response);
        	});
        	
        };
        
         vm.cancel  = function() {
        	$state.go('app.listBanks');
        };
    }
})();