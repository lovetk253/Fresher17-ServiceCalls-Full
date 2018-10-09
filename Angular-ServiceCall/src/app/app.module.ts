import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { CustomersComponent } from './customers/customers.component';
import { ContactsComponent } from './contacts/contacts.component';
import { ChargeCodesComponent } from './charge-codes/charge-codes.component';
import { ProblemsComponent } from './problems/problems.component';
import { ServiceRequestCallsComponent } from './service-request-calls/service-request-calls.component';
import { StatusCodesComponent } from './status-codes/status-codes.component';
import { ServiceRequestActionsComponent } from './service-request-actions/service-request-actions.component';
import { ActionsComponent } from './actions/actions.component';
import { OutcomeCodesComponent } from './outcome-codes/outcome-codes.component';
import { TechniciansComponent } from './technicians/technicians.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { CustomersService } from "./service/customers.service";
import {routing} from "./app.routing";
import { CustomerCreateComponent } from './customers/customer-create/customer-create.component';
import { ChargeCodesCreateComponent } from './charge-codes/charge-codes-create/charge-codes-create.component';
import {ChargeCodesService} from "./service/charge-codes.service";
import { ChargeCodesEditComponent } from './charge-codes/charge-codes-edit/charge-codes-edit.component';
import { ActionsCreateComponent } from './actions/actions-create/actions-create.component';
import { ActionsEditComponent } from './actions/actions-edit/actions-edit.component';
import { OutcomeCodesCreateComponent } from './outcome-codes/outcome-codes-create/outcome-codes-create.component';
import { OutcomeCodesEditComponent } from './outcome-codes/outcome-codes-edit/outcome-codes-edit.component';
import { ProblemsCreateComponent } from './problems/problems-create/problems-create.component';
import { ProblemsEditComponent } from './problems/problems-edit/problems-edit.component';
import { StatusCodeCreateComponent } from './status-codes/status-code-create/status-code-create.component';
import { StatusCodeEditComponent } from './status-codes/status-code-edit/status-code-edit.component';
import { TechniciansCreateComponent } from './technicians/technicians-create/technicians-create.component';
import { TechniciansEditComponent } from './technicians/technicians-edit/technicians-edit.component';
import { CustomerEditComponent } from './customers/customer-edit/customer-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    CustomersComponent,
    ContactsComponent,
    ChargeCodesComponent,
    ProblemsComponent,
    ServiceRequestCallsComponent,
    StatusCodesComponent,
    ServiceRequestActionsComponent,
    ActionsComponent,
    OutcomeCodesComponent,
    TechniciansComponent,
    CustomerCreateComponent,
    ChargeCodesCreateComponent,
    ChargeCodesEditComponent,
    ActionsCreateComponent,
    ActionsEditComponent,
    OutcomeCodesCreateComponent,
    OutcomeCodesEditComponent,
    ProblemsCreateComponent,
    ProblemsEditComponent,
    StatusCodeCreateComponent,
    StatusCodeEditComponent,
    TechniciansCreateComponent,
    TechniciansEditComponent,
    CustomerEditComponent
  ],
  imports: [
    BrowserModule,
    routing,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule

  ],
  providers: [CustomersService,ChargeCodesService],
  bootstrap: [AppComponent]
})
export class AppModule { }
