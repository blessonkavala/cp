(function () {
    'use strict';
    angular.module('app.bankmaintenance').controller('ControllerEditBank', ControllerEditBank);
    /* @ngInject */
    function ControllerEditBank(OrganizationService,organizationDetails,$state, $rootScope, $http) {
        /* jshint validthis: true */

        var vm = this;
        vm.pageTitle="Modify Bank Account";
        vm.isView = false;
        vm.isEdit = true;
        vm.isNew  = false;
        
        vm.org = organizationDetails;
        vm.statusCodes = OrganizationService.getStatusList();
        vm.legalTypeCodes = OrganizationService.getLegalIDTypes();
        
        vm.updateBank = function (org) {
       
        	$http.put('/organization/update',org).then(function(response){
        		$state.go('app.listBanks');
        		console.log(response);
        	});
        	
        };
        
       vm.cancel  = function() {
        	$state.go('app.listBanks');
        };
      
    }
})();