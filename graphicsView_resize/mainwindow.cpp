#include "mainwindow.h"
#include "ui_mainwindow.h"
#include <QGraphicsProxyWidget>
#include <QGraphicsScene>
#include <QDebug>

MainWindow::MainWindow(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::MainWindow)
{
    ui->setupUi(this);
    QGraphicsScene* scene = new QGraphicsScene(this);
    ui->graphicsView->setScene(scene);
    ui->graphicsView->setBackgroundBrush(QBrush(Qt::blue, Qt::SolidPattern));
}

MainWindow::~MainWindow()
{
    delete ui;
}

void MainWindow::mousePressEvent(QMouseEvent* event)
{
    QPoint remapped = ui->graphicsView->mapFromParent(event->pos());
    QRectF bounds = ui->graphicsView->scene()->itemsBoundingRect();
    bounds.setWidth(remapped.x());
    bounds.setHeight(remapped.y());
    ui->graphicsView->setFixedSize(remapped.x(), remapped.y());
    ui->graphicsView->setSceneRect(0, 0, remapped.x(), remapped.y());
    ui->graphicsView->fitInView(bounds, Qt::KeepAspectRatioByExpanding);
    ui->graphicsView->centerOn(0, 0);
    ui->graphicsView->show();
    qDebug() << bounds;
}
