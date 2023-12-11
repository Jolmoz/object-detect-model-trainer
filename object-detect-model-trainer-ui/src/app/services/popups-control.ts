import { Injectable } from '@angular/core';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ConfirmComponent } from '../view/dialogs/confirm/confirm.component';
import { SpinnerComponent } from '../view/dialogs/spinner/spinner.component';


@Injectable({
    providedIn: 'root'
})
export class PopupsControl {

    constructor(private dialog: MatDialog,
        private snackBar: MatSnackBar) { }

    private spinnerDialogRef: MatDialogRef<any>;
    private confirmDialogRef: MatDialogRef<any>;

    public WIDTH_DEFAULT: string = '500px';
    public HEIGHT_DEFAULT: string = 'fit-content';



    openConfirmationDialog(message: string) {
        if (this.confirmDialogRef == undefined)
            this.confirmDialogRef = this.dialog.open(ConfirmComponent, {
                width: '500px',
                data: {
                    message: message
                },
                panelClass: 'confirm-dialog-container'
            });
        this.confirmDialogRef.afterClosed().subscribe(ok => { this.confirmDialogRef = undefined; });
        return this.confirmDialogRef;
    }

    openSpinnerDialog(message: string) {
        if (this.spinnerDialogRef == undefined)
            this.spinnerDialogRef = this.dialog.open(SpinnerComponent, {
                width: '500px',
                data: {
                    message: message
                }
            });
        this.spinnerDialogRef.afterClosed().subscribe(ok => { this.spinnerDialogRef = undefined; });
        return this.spinnerDialogRef;
    }
    /**
     * Creates a small pop up with a message that last as specified
     * in duration param, also has an optional default action to hide
     * the dialog
     * @param message
     * String: Message to display 
     * @param action 
     * String to display in hide button
     * @param duration 
     * number to specify duration for the message
     */
    openSnackBar(message: string, action: string, duration: number) {
        this.snackBar.open(message, action, {
            duration: duration * 1000,
        });
    }

    closeAnyDialog() {
        this.dialog.ngOnDestroy();
    }

    closeSpinnerDialog() {
        if (this.spinnerDialogRef != undefined) {
            this.spinnerDialogRef.close();
            this.spinnerDialogRef = undefined;
        }
    }

    closeConfirmDialog() {
        if (this.confirmDialogRef != undefined) {
            this.confirmDialogRef.close();
            this.confirmDialogRef = undefined;
        }
    }

    /**
     * Opens a managed pop up with given component
     * @param component -> example popupsControl.openAnyDialog(ImportComponent, data)
     * @param data -> example data = { width: '500px', data: { message: message } }
     */
    openAnyDialog(component: any, data: any): any {
        return this.dialog.open(component, data)
    }
}
