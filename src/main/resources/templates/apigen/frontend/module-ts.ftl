import { TagModule } from 'primeng/tag';
import { SharedModule } from 'primeng/api';
import { TableModule } from 'primeng/table';
import { ToastModule } from 'primeng/toast';
import { ToolbarModule } from 'primeng/toolbar';
import { DropdownModule } from 'primeng/dropdown';
import { CheckboxModule } from 'primeng/checkbox';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { TranslateModule } from '@ngx-translate/core';
import { PrimengSharedModule } from '@hvlng/framework-core/shared';
import { HvlFormItemModule, HvlFormMessageModule, HvlMlDropdownModule } from '@hvlng/framework-core/form';

import { UiSharedModule } from 'ui-shared';

import { ${model.apiName}RoutingModule } from './${helper.tsName}-routing.module';
import { ${model.apiName}PageComponent } from './component/${helper.tsName}-page.component';
import { ${model.apiName}ListComponent } from './component/${helper.tsName}-list.component';

@NgModule({
declarations: [${model.apiName}PageComponent, ${model.apiName}ListComponent],
imports: [
CommonModule,
PrimengSharedModule,
ToolbarModule,
TableModule,
TagModule,
FormsModule,
SharedModule,
ReactiveFormsModule,
HvlFormMessageModule,
HvlFormItemModule,
HvlMlDropdownModule,
UiSharedModule,
DropdownModule,
ToastModule,
CheckboxModule,
TranslateModule.forChild(),
${model.apiName}RoutingModule,
],
exports: [${model.apiName}PageComponent, ${model.apiName}ListComponent],
})
export class ${model.apiName}Module {}