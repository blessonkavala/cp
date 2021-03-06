(function () {
    'use strict';
    angular.module('app.fundtransfer').controller('ControllerViewInternalFT', ControllerViewInternalFT);
    /* @ngInject */
    function ControllerViewInternalFT(FundTransferService,fundTransferDetails,$state, $rootScope, $http,$stateParams) {
        /* jshint validthis: true */

        var vm = this;
        vm.formHeader = 'View Internal FundTransfer';
        vm.isNew =  false;
        vm.isView = true;
        vm.isEdit = false;
        
        vm.prodStatusCodes = FundTransferService.getProductStatusCodes();
        
        vm.screenFT  = fundTransferDetails;
        vm.isBankUser = fundTransferDetails.bankUser;
        vm.isCustomerUser = fundTransferDetails.customerUser;
        
        vm.cancel = function () {
          $state.go('app.listPendingFTs',{tnxStatCode: "03"});	
        };
        
        vm.ApproveOrReject = function () {
             $http.post('/ft/update',vm.screenFT).then(function(response){
        		$state.go('app.listPendingFTs');
        		console.log(response);
        	});
        }
        
        vm.canRenderReportingMessageSection = function (){
            if(vm.isBankUser){
                return true;
            }
            else
            {
                 return  vm.screenFT.fundTransfer.tnxStatCode === '04';       
            }
        }
    }
})();