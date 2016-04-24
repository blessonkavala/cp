(function () {
    'use strict';
    angular.module('app.fundtransfer').controller('ControllerViewInternalFT', ControllerViewInternalFT);
    /* @ngInject */
    function ControllerViewInternalFT(fundTransferDetails,$state, $rootScope, $http,$stateParams) {
        /* jshint validthis: true */

        var vm = this;
        vm.formHeader = 'View Internal FundTransfer';
        vm.isNew =  false;
        vm.isView = true;
        vm.isEdit = false;
        
        vm.screenFT  = fundTransferDetails;
        vm.cancel = function () {
          $state.go('app.listPendingFTs',{tnxStatCode: "03"});	
        };
    }
})();