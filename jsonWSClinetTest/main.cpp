#include <QCoreApplication>
#include <QtCore/QUrl>
#include <QtNetwork/QNetworkRequest>
#include <QtNetwork/QNetworkReply>
#include <QJsonDocument>
#include <QJsonObject>

int main(int argc, char *argv[])
{
    QCoreApplication app(argc, argv);

    QEventLoop eventLoop;
    QNetworkAccessManager mgr;
    QObject::connect(&mgr, SIGNAL(finished(QNetworkReply*)), &eventLoop, SLOT(quit()));
    QNetworkRequest req( QUrl( QString("http://api.openweathermap.org/data/2.5/weather?q=colombo,lk") ) );
    QNetworkReply *reply = mgr.get(req);
    eventLoop.exec();

    if (reply->error() == QNetworkReply::NoError) {
        QString strReply = (QString)reply->readAll();
        QJsonDocument jsonResponse = QJsonDocument::fromJson(strReply.toUtf8());
        QJsonObject jsonObj = jsonResponse.object();
        qDebug() << "name:" << jsonObj["name"].toString();
        qDebug() << "lat:" << jsonObj.value(QString("coord")).toObject()["lat"].toDouble();
        qDebug() << "lat:" << jsonObj.value(QString("coord")).toObject()["lon"].toDouble();
        delete reply;
    }
    else {
        qDebug() << "Failure" <<reply->errorString();
        delete reply;
    }
    return 0;
}
